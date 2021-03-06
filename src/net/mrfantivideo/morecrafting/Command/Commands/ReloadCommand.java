package net.mrfantivideo.morecrafting.Command.Commands;

import net.mrfantivideo.morecrafting.Command.AbstractCommand;
import net.mrfantivideo.morecrafting.Main;
import net.mrfantivideo.morecrafting.Recipes.RecipesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends AbstractCommand
{
    public ReloadCommand()
    {
        super("reload");
    }

    public boolean HasPermission(CommandSender sender)
    {
        return (sender.isOp() || sender.hasPermission(Main.getInstance().getConfigPermissions().GetAdminReloadPerm()) ||
                sender.hasPermission(Main.getInstance().getConfigPermissions().GetAdminAllPerm()));
    }

    public boolean Execute(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Main.getInstance().loadSettings();
        RecipesManager.GetInstance().LoadRecipes();
        sender.sendMessage(Main.getInstance().getConfigMessages().GetPrefix() + Main.getInstance().getConfigMessages().GetCmdReloadMsg());
        return true;
    }
}
