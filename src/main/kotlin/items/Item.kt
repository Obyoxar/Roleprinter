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

package items

import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.property.TextAlignment
import com.itextpdf.layout.property.UnitValue
import pdfu.cell
import pdfu.table

fun Document.propertyTable(vararg props: Pair<String, String>){
    table(2){
        setFont("badscript")
        setFontSize(10f)
        width = UnitValue.createPercentValue(100f)
        props.forEach {
            cell(Paragraph(it.first).setFixedLeading(12f).setMargin(0f).setTextAlignment(TextAlignment.RIGHT)).setPadding(0f).setPaddingRight(3f)
            cell(Paragraph(it.second).setFixedLeading(12f).setMargin(0f)).setPadding(0f).setPaddingLeft(3f)
        }
    }
}

abstract class Item(val itemName: String) {
    abstract val filename: String

    fun genPdf(document: Document){
        document.add(Paragraph(itemName).setFont("metamorphous").setTextAlignment(TextAlignment.CENTER))
        genPdfDesc(document)
    }
    abstract fun genPdfDesc(document: Document)
}