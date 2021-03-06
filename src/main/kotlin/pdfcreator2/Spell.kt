/*
 * Roleprinter - Print itemcards for your Pathfinder campaign.
 *     Copyright (C) 2018 Erik Mayrhofer
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pdfcreator2


data class Spell(
    val name: String,
    val school: String,
    val domain: String,
    val level: String,
    val time: String,
    val components: String,
    val range: String,
    val target: String,
    val duration: String,
    val savingThrow: String,
    val resistance: String,
    private val description: Map<String, Description>
){
    fun getDescriptionFor(type: String): Description{
        if(!description.containsKey(type))
            throw Exception("Spell '$name' doesn't contain a description of type '$type'. Available types: ${description.keys.joinToString()}")
        return description[type]!!
    }
    operator fun get(type: String): Description{
        return getDescriptionFor(type)
    }
}

