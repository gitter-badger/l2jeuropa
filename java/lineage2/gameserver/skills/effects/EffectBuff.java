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
package lineage2.gameserver.skills.effects;

import lineage2.gameserver.model.Effect;
import lineage2.gameserver.model.Player;
import lineage2.gameserver.model.Skill;
import lineage2.gameserver.stats.Env;

/**
 * @author Mobius
 * @version $Revision: 1.0 $
 */
public final class EffectBuff extends Effect
{
	/**
	 * Constructor for EffectBuff.
	 * @param env Env
	 * @param template EffectTemplate
	 */
	public EffectBuff(Env env, EffectTemplate template)
	{
		super(env, template);
	}
	
	/**
	 * Method onStart.
	 */
	@Override
	public void onStart()
	{
		super.onStart();
		if (getEffected().isPlayer())
		{
			final Player player = (Player) getEffected();
			if (player.getEffectList().getEffectsBySkillId(Skill.SKILL_DUAL_CAST) != null)
			{
				player.setIsEnabledDoubleCast(true);
			}
		}
	}
	
	/**
	 * Method onExit.
	 */
	@Override
	public void onExit()
	{
		super.onExit();
		if (getEffected().isPlayer())
		{
			final Player player = (Player) getEffected();
			if (player.getEffectList().getEffectsBySkillId(Skill.SKILL_DUAL_CAST) != null)
			{
				player.setIsEnabledDoubleCast(false);
			}
		}
	}
	
	/**
	 * Method onActionTime.
	 * @return boolean
	 */
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
