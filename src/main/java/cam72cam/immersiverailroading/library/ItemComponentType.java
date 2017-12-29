package cam72cam.immersiverailroading.library;

import java.util.ArrayList;
import java.util.List;

import cam72cam.immersiverailroading.util.TextUtil;

public enum ItemComponentType {
	FRAME(AssemblyStep.FRAME, CraftingType.HAMMER, RenderComponentType.FRAME), //TODO
	
	// MALLET
	FRONT_FRAME(AssemblyStep.FRAME, CraftingType.HAMMER, RenderComponentType.FRONT_LOCOMOTIVE),
	
	// STANDARD
	BOGEY_WHEEL(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.BOGEY_POS_WHEEL_X),
	BOGEY(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.BOGEY_POS),
	BOGEY_FRONT_WHEEL(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.BOGEY_FRONT_WHEEL_X),
	BOGEY_FRONT(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.BOGEY_FRONT),
	BOGEY_REAR_WHEEL(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.BOGEY_REAR_WHEEL_X),
	BOGEY_REAR(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.BOGEY_REAR),
	FRAME_WHEEL(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.FRAME_WHEEL_X),
	
	SHELL(AssemblyStep.SHELL, CraftingType.PLATE_LARGE, RenderComponentType.SHELL),
	
	// LOCOMOTIVE
	CAB(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.CAB),
	BELL(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.BELL),
	WHISTLE(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.WHISTLE),
	HORN(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.HORN),
	
	// DIESEL
	FUEL_TANK(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.FUEL_TANK),
	ALTERNATOR(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.ALTERNATOR),
	ENGINE_BLOCK(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.ENGINE_BLOCK),
	PISTON(AssemblyStep.SHELL, CraftingType.HAMMER, RenderComponentType.PISTON_X),
	
	//STEAM
	FIREBOX(AssemblyStep.BOILER, CraftingType.HAMMER, RenderComponentType.FIREBOX),
	STEAM_CHEST(AssemblyStep.FRAME, CraftingType.HAMMER, RenderComponentType.STEAM_CHEST),
	STEAM_CHEST_FRONT(AssemblyStep.FRAME, CraftingType.HAMMER, RenderComponentType.STEAM_CHEST_FRONT),
	STEAM_CHEST_REAR(AssemblyStep.FRAME, CraftingType.HAMMER, RenderComponentType.STEAM_CHEST_REAR),
	BOILER_SEGMENT(AssemblyStep.BOILER, CraftingType.HAMMER, RenderComponentType.BOILER_SEGMENT_X),
	PIPING(AssemblyStep.BOILER, CraftingType.HAMMER, RenderComponentType.PIPING),
	
	// WALCHERTS
	WHEEL_DRIVER(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.WHEEL_DRIVER_X),
	WHEEL_DRIVER_FRONT(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.WHEEL_DRIVER_FRONT_X), // MALLET
	WHEEL_DRIVER_REAR(AssemblyStep.WHEELS, CraftingType.HAMMER, RenderComponentType.WHEEL_DRIVER_REAR_X), // MALLET
	
	CYLINDER(AssemblyStep.FRAME, CraftingType.HAMMER, RenderComponentType.CYLINDER_SIDE),
	SIDE_ROD(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.SIDE_ROD_SIDE),
	MAIN_ROD(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.MAIN_ROD_SIDE),
	PISTON_ROD(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.PISTON_ROD_SIDE),
	
	UNION_LINK(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.UNION_LINK_SIDE),
	COMBINATION_LEVER(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.COMBINATION_LEVER_SIDE),
	VALVE_STEM(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.VALVE_STEM_SIDE),
	RADIUS_BAR(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.RADIUS_BAR_SIDE),
	EXPANSION_LINK(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.EXPANSION_LINK_SIDE),
	ECCENTRIC_ROD(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.ECCENTRIC_ROD_SIDE),
	ECCENTRIC_CRANK(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.ECCENTRIC_CRANK_SIDE),
	REVERSING_ARM(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.REVERSING_ARM_SIDE),
	LIFTING_LINK(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.LIFTING_LINK_SIDE),
	REACH_ROD(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, RenderComponentType.REACH_ROD_SIDE),
	
	WALCHERTS_LINKAGE(AssemblyStep.VALVE_GEAR, CraftingType.HAMMER, 
			RenderComponentType.UNION_LINK_SIDE,
			RenderComponentType.COMBINATION_LEVER_SIDE,
			RenderComponentType.VALVE_STEM_SIDE,
			RenderComponentType.RADIUS_BAR_SIDE,
			RenderComponentType.EXPANSION_LINK_SIDE,
			RenderComponentType.ECCENTRIC_ROD_SIDE,
			RenderComponentType.ECCENTRIC_CRANK_SIDE,
			RenderComponentType.REVERSING_ARM_SIDE,
			RenderComponentType.LIFTING_LINK_SIDE,
			RenderComponentType.REACH_ROD_SIDE
	),
	;
	
	public final AssemblyStep step;
	public final List<RenderComponentType> render;
	public final CraftingType crafting;

	ItemComponentType(AssemblyStep step, CraftingType crafting, RenderComponentType ... render) {
		this.crafting = crafting;
		this.step = step;
		this.render = new ArrayList<RenderComponentType>();
		
		for (RenderComponentType r : render) {
			this.render.add(r);
		}
	}
	
	public boolean isWheelPart() {
		switch (this) {
		case BOGEY_FRONT_WHEEL:
		case BOGEY_FRONT:
		case BOGEY_REAR_WHEEL:
		case BOGEY_REAR:
		case WHEEL_DRIVER:
		case WHEEL_DRIVER_FRONT:
		case WHEEL_DRIVER_REAR:
		case FRAME_WHEEL:
			return true;
		default:
			return false;
		}
	}

	public static ItemComponentType from(RenderComponentType renderComponent) {
		for (ItemComponentType item : values()) {
			for (RenderComponentType render : item.render) {
				if (render == renderComponent) {
					return item;
				}
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return TextUtil.translate("part.immersiverailroading:component." + super.toString().toLowerCase());
	}
}
