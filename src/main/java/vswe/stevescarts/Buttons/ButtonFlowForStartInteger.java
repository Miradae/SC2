package vswe.stevescarts.Buttons;
import net.minecraft.entity.player.EntityPlayer;
import vswe.stevescarts.Modules.ModuleBase;
import vswe.stevescarts.Modules.Workers.ModuleComputer;
import vswe.stevescarts.Computer.ComputerProg;
import vswe.stevescarts.Computer.ComputerTask;

import java.util.ArrayList;
public class ButtonFlowForStartInteger extends ButtonFlowForInteger {
	

    public ButtonFlowForStartInteger(ModuleComputer module, LOCATION loc, int dif)
    {
		super(module, loc, dif);	
	}
	

	@Override
	protected String getName() {
		return "start";
	}
	
	@Override
	protected boolean isVarVisible(ComputerTask task) {
		return task.getFlowForUseStartVar();
	}
	
	@Override
	protected int getInteger(ComputerTask task) {
		return task.getFlowForStartInteger();
	}
	
	@Override
	protected void setInteger(ComputerTask task, int val) {
		task.setFlowForStartInteger(val);
	}
	

}