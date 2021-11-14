package ru.llxodz.pizzahouse.activities.fragments.main_menu_fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.poovam.pinedittextfield.PinField
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.activities.MainActivity
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class OTPCodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_o_t_p_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        line_pin.onTextCompleteListener = listenerPin
    }

    private val listenerPin = object : PinField.OnTextCompleteListener {
        private var currentCode: Int = 5555
        override fun onTextComplete(enteredText: String): Boolean {
            return if (currentCode == enteredText.toInt()) {
                MotionToast.createToast(
                    context as Activity,
                    "Успешно!",
                    "Вы успешно авторизовались",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(context!!, R.font.montserrat_medium)
                )
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                true
            } else {
                false
            }
        }
    }
}
