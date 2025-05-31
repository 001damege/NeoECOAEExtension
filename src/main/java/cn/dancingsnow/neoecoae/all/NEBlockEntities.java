package cn.dancingsnow.neoecoae.all;

import cn.dancingsnow.neoecoae.api.ECOTier;
import cn.dancingsnow.neoecoae.api.IECOTier;
import cn.dancingsnow.neoecoae.blocks.NEBlock;
import cn.dancingsnow.neoecoae.blocks.crafting.ECOFluidInputHatchBlock;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOCraftingParallelCoreBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOCraftingPatternBusBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOCraftingSystemBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOCraftingVentBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOCraftingWorkerBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOFluidInputHatchBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.crafting.ECOFluidOutputHatchBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.storage.ECODriveBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.storage.ECOStorageSystemBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.storage.ECOStorageVentBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.MachineCasingBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.storage.MachineEnergyCellBlockEntity;
import cn.dancingsnow.neoecoae.blocks.entity.MachineInterfaceBlockEntity;
import cn.dancingsnow.neoecoae.client.renderer.blockentity.ECODriveRenderer;
import cn.dancingsnow.neoecoae.multiblock.calculator.NEComputationClusterCalculator;
import cn.dancingsnow.neoecoae.multiblock.calculator.NECraftingClusterCalculator;
import cn.dancingsnow.neoecoae.multiblock.calculator.NEStorageClusterCalculator;
import cn.dancingsnow.neoecoae.multiblock.cluster.NEComputationCluster;
import cn.dancingsnow.neoecoae.multiblock.cluster.NECraftingCluster;
import cn.dancingsnow.neoecoae.multiblock.cluster.NEStorageCluster;
import cn.dancingsnow.neoecoae.registration.NEBlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.neoforged.neoforge.capabilities.Capabilities;

import static cn.dancingsnow.neoecoae.NeoECOAE.REGISTRATE;

public class NEBlockEntities {

    public static final BlockEntityEntry<MachineCasingBlockEntity<NEComputationCluster>> COMPUTATION_CASING = REGISTRATE
        .<MachineCasingBlockEntity<NEComputationCluster>, NEComputationCluster>blockEntityClusterElement(
            "computation_casing",
            NEComputationClusterCalculator::new,
            MachineCasingBlockEntity::new
        )
        .forBlock(NEBlocks.COMPUTATION_CASING)
        .validBlock(NEBlocks.COMPUTATION_CASING)
        .register();

    public static final BlockEntityEntry<MachineCasingBlockEntity<NECraftingCluster>> CRAFTING_CASING = REGISTRATE
        .<MachineCasingBlockEntity<NECraftingCluster>, NECraftingCluster>blockEntityClusterElement(
            "crafting_casing",
            NECraftingClusterCalculator::new,
            MachineCasingBlockEntity::new
        )
        .forBlock(NEBlocks.CRAFTING_CASING)
        .validBlock(NEBlocks.CRAFTING_CASING)
        .register();

    public static final NEBlockEntityEntry<MachineCasingBlockEntity<NEStorageCluster>> STORAGE_CASING = REGISTRATE
        .<MachineCasingBlockEntity<NEStorageCluster>, NEStorageCluster>blockEntityClusterElement(
            "storage_casing",
            NEStorageClusterCalculator::new,
            MachineCasingBlockEntity::new
        )
        .forBlock(NEBlocks.STORAGE_CASING)
        .validBlock(NEBlocks.STORAGE_CASING)
        .register();

    public static final BlockEntityEntry<MachineInterfaceBlockEntity<NEComputationCluster>> COMPUTATION_INTERFACE = REGISTRATE
        .<MachineInterfaceBlockEntity<NEComputationCluster>, NEComputationCluster>blockEntityClusterElement(
            "computation_interface",
            NEComputationClusterCalculator::new,
            MachineInterfaceBlockEntity::new
        )
        .forBlock(NEBlocks.COMPUTATION_INTERFACE)
        .validBlock(NEBlocks.COMPUTATION_INTERFACE)
        .register();

    public static final BlockEntityEntry<MachineInterfaceBlockEntity<NECraftingCluster>> CRAFTING_INTERFACE = REGISTRATE
        .<MachineInterfaceBlockEntity<NECraftingCluster>, NECraftingCluster>blockEntityClusterElement(
            "crafting_interface",
            NECraftingClusterCalculator::new,
            MachineInterfaceBlockEntity::new
        )
        .forBlock(NEBlocks.CRAFTING_INTERFACE)
        .validBlock(NEBlocks.CRAFTING_INTERFACE)
        .register();

    public static final NEBlockEntityEntry<MachineInterfaceBlockEntity<NEStorageCluster>> STORAGE_INTERFACE = REGISTRATE
        .<MachineInterfaceBlockEntity<NEStorageCluster>, NEStorageCluster>blockEntityClusterElement(
            "storage_interface",
            NEStorageClusterCalculator::new,
            MachineInterfaceBlockEntity::new
        )
        .forBlock(NEBlocks.STORAGE_INTERFACE)
        .validBlock(NEBlocks.STORAGE_INTERFACE)
        .register();

    public static final NEBlockEntityEntry<ECODriveBlockEntity> ECO_DRIVE = REGISTRATE
        .blockEntityBlockLinked(
            "eco_drive",
            ECODriveBlockEntity::new
        )
        .forBlock(NEBlocks.ECO_DRIVE)
        .validBlock(NEBlocks.ECO_DRIVE)
        .renderer(() -> ECODriveRenderer::new)
        .registerCapability(event -> event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            NEBlockEntities.ECO_DRIVE.get(),
            (be, side) -> be.HANDLER
        ))
        .register();

    public static final NEBlockEntityEntry<ECOStorageVentBlockEntity> STORAGE_VENT = REGISTRATE
        .blockEntityBlockLinked(
            "storage_vent",
            ECOStorageVentBlockEntity::new
        )
        .forBlock(NEBlocks.STORAGE_VENT)
        .validBlock(NEBlocks.STORAGE_VENT)
        .register();

    public static final NEBlockEntityEntry<ECOStorageSystemBlockEntity> STORAGE_SYSTEM_L4 = REGISTRATE
        .blockEntityBlockLinked(
            "storage_system_l4",
            ECOStorageSystemBlockEntity::createL4
        )
        .forBlock(NEBlocks.STORAGE_SYSTEM_L4)
        .validBlock(NEBlocks.STORAGE_SYSTEM_L4)
        .register();

    public static final NEBlockEntityEntry<ECOStorageSystemBlockEntity> STORAGE_SYSTEM_L6 = REGISTRATE
        .blockEntityBlockLinked(
            "storage_system_l6",
            ECOStorageSystemBlockEntity::createL6
        )
        .forBlock(NEBlocks.STORAGE_SYSTEM_L6)
        .validBlock(NEBlocks.STORAGE_SYSTEM_L6)
        .register();

    public static final NEBlockEntityEntry<ECOStorageSystemBlockEntity> STORAGE_SYSTEM_L9 = REGISTRATE
        .blockEntityBlockLinked(
            "storage_system_l9",
            ECOStorageSystemBlockEntity::createL9
        )
        .forBlock(NEBlocks.STORAGE_SYSTEM_L9)
        .validBlock(NEBlocks.STORAGE_SYSTEM_L9)
        .register();

    public static final NEBlockEntityEntry<MachineEnergyCellBlockEntity> ENERGY_CELL_L4 = REGISTRATE
        .tierBlockEntityBlockLinked(
            "energy_cell_l4",
            ECOTier.L4,
            MachineEnergyCellBlockEntity::new
        )
        .forBlock(NEBlocks.ENERGY_CELL_L4)
        .validBlock(NEBlocks.ENERGY_CELL_L4)
        .register();

    public static final NEBlockEntityEntry<MachineEnergyCellBlockEntity> ENERGY_CELL_L6 = REGISTRATE
        .tierBlockEntityBlockLinked(
            "energy_cell_l6",
            ECOTier.L6,
            MachineEnergyCellBlockEntity::new
        )
        .forBlock(NEBlocks.ENERGY_CELL_L6)
        .validBlock(NEBlocks.ENERGY_CELL_L6)
        .register();

    public static final NEBlockEntityEntry<MachineEnergyCellBlockEntity> ENERGY_CELL_L9 = REGISTRATE
        .tierBlockEntityBlockLinked(
            "energy_cell_l9",
            ECOTier.L9,
            MachineEnergyCellBlockEntity::new
        )
        .forBlock(NEBlocks.ENERGY_CELL_L9)
        .validBlock(NEBlocks.ENERGY_CELL_L9)
        .register();

    public static final NEBlockEntityEntry<ECOCraftingSystemBlockEntity> CRAFTING_SYSTEM_L4 = createCraftingSystem(
        ECOTier.L4,
        "l4",
        NEBlocks.CRAFTING_SYSTEM_L4
    );
    public static final NEBlockEntityEntry<ECOCraftingSystemBlockEntity> CRAFTING_SYSTEM_L6 = createCraftingSystem(
        ECOTier.L6,
        "l6",
        NEBlocks.CRAFTING_SYSTEM_L6
    );
    public static final NEBlockEntityEntry<ECOCraftingSystemBlockEntity> CRAFTING_SYSTEM_L9 = createCraftingSystem(
        ECOTier.L9,
        "l9",
        NEBlocks.CRAFTING_SYSTEM_L9
    );

    public static final NEBlockEntityEntry<ECOCraftingParallelCoreBlockEntity> CRAFTING_PARALLEL_CORE_L4 = createCraftingParallelCore(
        ECOTier.L4,
        "l4",
        NEBlocks.CRAFTING_PARALLEL_CORE_L4
    );
    public static final NEBlockEntityEntry<ECOCraftingParallelCoreBlockEntity> CRAFTING_PARALLEL_CORE_L6 = createCraftingParallelCore(
        ECOTier.L6,
        "l6",
        NEBlocks.CRAFTING_PARALLEL_CORE_L6
    );
    public static final NEBlockEntityEntry<ECOCraftingParallelCoreBlockEntity> CRAFTING_PARALLEL_CORE_L9 = createCraftingParallelCore(
        ECOTier.L9,
        "l9",
        NEBlocks.CRAFTING_PARALLEL_CORE_L9
    );

    public static final NEBlockEntityEntry<ECOCraftingVentBlockEntity> CRAFTING_VENT = REGISTRATE
        .blockEntityBlockLinked(
            "crafting_vent",
            ECOCraftingVentBlockEntity::new
        )
        .forBlock(NEBlocks.CRAFTING_VENT)
        .validBlock(NEBlocks.CRAFTING_VENT)
        .register();

    public static final NEBlockEntityEntry<ECOFluidInputHatchBlockEntity> INPUT_HATCH = REGISTRATE
        .blockEntityBlockLinked("input_hatch", ECOFluidInputHatchBlockEntity::new)
        .forBlock(NEBlocks.INPUT_HATCH)
        .validBlock(NEBlocks.INPUT_HATCH)
        .serverTicker(((level, pos, state, be) -> be.tick(level, pos, state)))
        .registerCapability(event -> {
            event.registerBlockEntity(
                Capabilities.FluidHandler.BLOCK,
                NEBlockEntities.INPUT_HATCH.get(),
                (be, side) -> be.getBlockState().getValue(ECOFluidInputHatchBlock.FACING) == side ? be.tank : null
            );
        })
        .register();

    public static final NEBlockEntityEntry<ECOFluidOutputHatchBlockEntity> OUTPUT_HATCH = REGISTRATE
        .blockEntityBlockLinked("output_hatch", ECOFluidOutputHatchBlockEntity::new)
        .forBlock(NEBlocks.OUTPUT_HATCH)
        .validBlock(NEBlocks.OUTPUT_HATCH)
        .serverTicker(((level, pos, state, be) -> be.tick(level, pos, state)))
        .registerCapability(event -> {
            event.registerBlockEntity(
                Capabilities.FluidHandler.BLOCK,
                NEBlockEntities.OUTPUT_HATCH.get(),
                (be, side) -> be.getBlockState().getValue(ECOFluidInputHatchBlock.FACING) == side ? be.tank : null
            );
        })
        .register();

    public static final NEBlockEntityEntry<ECOCraftingWorkerBlockEntity> CRAFTING_WORKER = REGISTRATE
        .blockEntityBlockLinked(
            "crafting_worker",
            ECOCraftingWorkerBlockEntity::new
        )
        .forBlock(NEBlocks.CRAFTING_WORKER)
        .validBlock(NEBlocks.CRAFTING_WORKER)
        .register();

    public static final NEBlockEntityEntry<ECOCraftingPatternBusBlockEntity> CRAFTING_PATTERN_BUS = REGISTRATE
        .blockEntityBlockLinked(
            "crafting_pattern_bus",
            ECOCraftingPatternBusBlockEntity::new
        )
        .forBlock(NEBlocks.CRAFTING_PATTERN_BUS)
        .validBlock(NEBlocks.CRAFTING_PATTERN_BUS)
        .registerCapability(e -> e.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            NEBlockEntities.CRAFTING_PATTERN_BUS.get(),
            (be, side) -> be.getItemHandler()
            )
        )
        .register();

    private static NEBlockEntityEntry<ECOCraftingSystemBlockEntity> createCraftingSystem(
        IECOTier tier,
        String tierString,
        BlockEntry<? extends NEBlock<ECOCraftingSystemBlockEntity>> block
    ) {
        return REGISTRATE
            .tierBlockEntityBlockLinked(
                "crafting_system_" + tierString,
                tier,
                ECOCraftingSystemBlockEntity::new
            )
            .forBlock(block)
            .validBlock(block)
            .register();
    }

    private static NEBlockEntityEntry<ECOCraftingParallelCoreBlockEntity> createCraftingParallelCore(
        IECOTier tier,
        String tierString,
        BlockEntry<? extends NEBlock<ECOCraftingParallelCoreBlockEntity>> block
    ) {
        return REGISTRATE
            .tierBlockEntityBlockLinked(
                "crafting_parallel_core_" + tierString,
                tier,
                ECOCraftingParallelCoreBlockEntity::new
            )
            .forBlock(block)
            .validBlock(block)
            .register();
    }

    public static void register() {

    }
}
