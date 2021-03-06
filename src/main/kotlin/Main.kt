import gui.main
import pdfcreator2.PdfCreator2
import java.nio.file.Paths

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



fun main(args: Array<String>) {
    if(args.isNotEmpty() && args[0] == "gui"){
        val newArgs = if(args.size > 1) args.slice(1 until args.lastIndex) else listOf()
        main(newArgs.toTypedArray())
    }else
        //PdfCreator().run(args.getOrElse(0, {"itemlist.txt"}), args.getOrElse(1, {"out.pdf"}))
        PdfCreator2(Paths.get(args.getOrElse(0, {"itemlist.txt"})))
}