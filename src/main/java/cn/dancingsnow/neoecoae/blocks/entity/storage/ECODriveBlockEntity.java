package cn.dancingsnow.neoecoae.blocks.entity.storage;

import cn.dancingsnow.neoecoae.blocks.storage.ECODriveBlock;
import cn.dancingsnow.neoecoae.client.model.data.ECODriveModelData;
import cn.dancingsnow.neoecoae.items.ECOStorageCellItem;
import cn.dancingsnow.neoecoae.items.cell.ECOStorageCell;
import com.lowdragmc.lowdraglib.syncdata.IEnhancedManaged;
import com.lowdragmc.lowdraglib.syncdata.IManagedStorage;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.annotation.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.blockentity.IAsyncAutoSyncBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.blockentity.IAutoPersistBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.field.FieldManagedStorage;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ECODriveBlockEntity extends AbstractStorageBlockEntity<ECODriveBlockEntity>
    implements IAsyncAutoSyncBlockEntity, IAutoPersistBlockEntity, IEnhancedManaged {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ECODriveBlockEntity.class);
    private final FieldManagedStorage syncStorage = new FieldManagedStorage(this);

    public final IItemHandler HANDLER = new IItemHandler() {

        @Override
        public int getSlots() {
            return 1;
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
            return cellStack != null ? cellStack : ItemStack.EMPTY;
        }

        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (cellStack != null) {
                return stack;
            } else {
                if (stack.isEmpty()) {
                    return ItemStack.EMPTY;
                }
                if (!simulate) {
                    setCellStack(stack.copyWithCount(1));
                }
                ItemStack copy = stack.copy();
                copy.shrink(1);
                return copy;
            }
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (cellStack == null) {
                return ItemStack.EMPTY;
            }
            if (amount <= 0) {
                return ItemStack.EMPTY;
            }
            ItemStack copy = cellStack.copyWithCount(1);
            if (!simulate) {
                setCellStack(null);
            }
            return copy;
        }

        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return stack.getItem() instanceof ECOStorageCellItem;
        }
    };

    @Getter
    @DescSynced
    @Persisted
    @RequireRerender
    @Nullable
    private ItemStack cellStack = null;

    public ECODriveBlockEntity(
        BlockEntityType<ECODriveBlockEntity> type,
        BlockPos pos,
        BlockState blockState
    ) {
        super(type, pos, blockState);
    }

    @Override
    public ModelData getModelData() {
        return ECODriveModelData.create(cellStack == null ? ItemStack.EMPTY : cellStack);
    }

    public void setCellStack(@Nullable ItemStack cellStack) {
        this.cellStack = cellStack;
        if (cellStack != null) {
            getLevel().setBlockAndUpdate(getBlockPos(), getBlockState().setValue(ECODriveBlock.HAS_CELL, true));
        } else {
            getLevel().setBlockAndUpdate(getBlockPos(), getBlockState().setValue(ECODriveBlock.HAS_CELL, false));
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public IManagedStorage getSyncStorage() {
        return syncStorage;
    }

    @Override
    public void onChanged() {
        setChanged();
        markForUpdate();
    }

    @Override
    public void scheduleRenderUpdate() {
        markForClientUpdate();
    }

    @Override
    public IManagedStorage getRootStorage() {
        return getSyncStorage();
    }

    @Override
    public void addAdditionalDrops(Level level, BlockPos pos, List<ItemStack> drops) {
        super.addAdditionalDrops(level, pos, drops);
        if (cellStack != null) {
            drops.add(cellStack);
        }
    }

    @Nullable
    public ECOStorageCell getCellInventory() {
        if (cellStack != null) {
            return ECOStorageCellItem.getCellInventory(cellStack);
        }
        return null;
    }
}
