package com.kapil.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       buGetAge.setOnClickListener()
//       {


//           val datePicker=get
           val today=Calendar.getInstance()

           datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
               today.get(Calendar.DAY_OF_MONTH)

           ) { view, year, month, day ->

               var countDate=Dates(day,month+1,year)

               var find=FindAge()
               tvAgeShow.setText(find.Cal(countDate))
              var msg="you select $day / $month/ $year"

               Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
           }
       }
    }

//}

class Dates(bDay: Int, bMonth: Int, bYear: Int)
{
    var bDay:Int
    var bMonth:Int
    var bYear:Int
    var cYear:Int
    var cMonth:Int
    var cDay:Int
    init {

        this.bDay=bDay
        this.bMonth=bMonth
        this.bYear=bYear
        this.cYear=Calendar.getInstance().get(Calendar.YEAR)
        this.cMonth=Calendar.getInstance().get(Calendar.MONTH)+1

        this.cDay=Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }

}

 interface  CalDates{
     fun Cal(data:Dates):String
     fun printAge(data:Dates):String


}
class FindAge:CalDates
{
    override fun Cal(data: Dates):String {
        if (data.cMonth< data.bMonth) {
            data.cYear--;
            data.cMonth += 12

        }
        if (data.cDay < data.bDay) {
            data.cMonth--;
            data.cDay += 31

        }

      return printAge(data)
    }
        override  fun printAge(data: Dates) :String
        {
            return ((data.cYear - data.bYear).toString()+" years " + (data.cMonth - data.bMonth).toString() + " months "+(data.cDay - data.bDay).toString()+" days ")

        }
    }




