/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package lineage2.gameserver.network.telnet.commands;

import java.util.LinkedHashSet;
import java.util.Set;

import lineage2.gameserver.network.telnet.TelnetCommand;
import lineage2.gameserver.network.telnet.TelnetCommandHolder;
import lineage2.gameserver.utils.AdminFunctions;

/**
 * @author UnAfraid
 */
public class TelnetGive implements TelnetCommandHolder
{
	/**
	 * Field _commands.
	 */
	private final Set<TelnetCommand> _commands = new LinkedHashSet<>();
	
	/**
	 * Constructor for TelnetBan.
	 */
	public TelnetGive()
	{
		_commands.add(new TelnetCommand("give")
		{
			@Override
			public String getUsage()
			{
				return "give <name> <itemid> <amount>";
			}
			
			@Override
			public String handle(String[] args)
			{
				if ((args.length == 0) || args[0].isEmpty() || args[1].isEmpty() || args[2].isEmpty())
				{
					return null;
				}
				if (AdminFunctions.give(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), "telnet"))
				{
					return "Added " + Integer.parseInt(args[2]) + " item:" + Integer.parseInt(args[1]) + " to the player:" + args[0] + ".\n";
				}
				return "Player not found.\n";
			}
		});
	}
	
	/**
	 * Method getCommands.
	 * @return Set<TelnetCommand>
	 * @see lineage2.gameserver.network.telnet.TelnetCommandHolder#getCommands()
	 */
	@Override
	public Set<TelnetCommand> getCommands()
	{
		return _commands;
	}
}