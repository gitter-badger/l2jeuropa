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
package lineage2.gameserver.network.loginservercon.gspackets;

import lineage2.gameserver.network.loginservercon.SendablePacket;

/**
 * @author Mobius
 * @version $Revision: 1.0 $
 */
public class Player2ndAuthSetPassword extends SendablePacket
{
	/**
	 * Field _login.
	 */
	private final String _login;
	/**
	 * Field _password.
	 */
	private final String _password;
	
	/**
	 * Constructor for Player2ndAuthSetPassword.
	 * @param login String
	 * @param pwd String
	 */
	public Player2ndAuthSetPassword(String login, String pwd)
	{
		_login = login;
		_password = pwd;
	}
	
	/**
	 * Method writeImpl.
	 */
	@Override
	protected void writeImpl()
	{
		writeC(0x15);
		writeS(_login);
		writeS(_password);
	}
}
