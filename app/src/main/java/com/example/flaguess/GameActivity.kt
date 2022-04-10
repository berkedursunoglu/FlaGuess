package com.example.flaguess

import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flaguess.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity() {
    private lateinit var design: ActivityGameBinding
    private var meter = 0
    private val dao = DAO()
    private var b = 0
    private var truemeter = 0
    private var falsemeter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this, R.layout.activity_game)
        val vt = Database(applicationContext)
        val a = dao.fiveQuest(vt)
        game(a, vt)
        design.metertv.setText("Kalan soru ${5 - meter}")
        design.truetv.setText("Doğru: $truemeter")
        design.falsetv.setText("Yanlış: $falsemeter")

        design.answerA.setOnClickListener {
            if (design.answerA.text == a.get(meter).bayrak_ad) {
                truemeter++
                design.truetv.setText("Doğru: $truemeter")
            } else {
                falsemeter++
                design.falsetv.setText("Yanlış: $falsemeter")
            }
            meter++
            check(meter, truemeter)
            game(a, vt)

        }

        design.answerB.setOnClickListener {
            if (design.answerB.text == a.get(meter).bayrak_ad) {
                truemeter++
                design.truetv.setText("Doğru: $truemeter")
            } else {
                falsemeter++
                design.falsetv.setText("Yanlış: $falsemeter")
            }
            meter++
            check(meter, truemeter)
            game(a, vt)
        }

        design.answerC.setOnClickListener {
            if (design.answerC.text == a.get(meter).bayrak_ad) {
                truemeter++
                design.truetv.setText("Doğru: $truemeter")
            } else {
                falsemeter++
                design.falsetv.setText("Yanlış: $falsemeter")
            }
            meter++
            check(meter, truemeter)
            game(a, vt)
        }

        design.answerD.setOnClickListener {
            if (design.answerD.text == a.get(meter).bayrak_ad) {
                truemeter++
                design.truetv.setText("Doğru: $truemeter")
            } else {
                falsemeter++
                design.falsetv.setText("Yanlış: $falsemeter")
            }
            meter++
            check(meter, truemeter)
            game(a, vt)
        }

    }


    fun game(arrayList: ArrayList<Flags>, vt: Database) {
        if (meter < 5) {
            design.metertv.setText("Kalan soru ${5 - meter}")
            design.flagiv.setImageResource(
                resources.getIdentifier(
                    arrayList.get(meter).bayrak_resim,
                    "drawable",
                    packageName
                )
            )
            var bayrak_id = arrayList.get(meter).bayrak_id
            var bayrak_ad = arrayList.get(meter).bayrak_ad
            var wrongarray = dao.wrongAnswer(vt, bayrak_id)
            var hashSet = HashSet<String>()
            hashSet.add(bayrak_ad)
            for (i in wrongarray) {
                hashSet.add(i.bayrak_ad)
            }
            design.answerA.setText(hashSet.toArray().get(0).toString())
            design.answerB.setText(hashSet.toArray().get(1).toString())
            design.answerC.setText(hashSet.toArray().get(2).toString())
            design.answerD.setText(hashSet.toArray().get(3).toString())
        }
    }


    fun check(meter1: Int, truemeter1: Int) {
        if (5 - meter1 == 0) {
            var result:Double = (truemeter1.toDouble()/5)*100
                var i: Intent = Intent(applicationContext, ResultActivty::class.java)
                i.putExtra("re",result.toInt())
            Log.e("TAG1",result.toInt().toString())
                startActivity(i)
            finish()
        }
    }
}