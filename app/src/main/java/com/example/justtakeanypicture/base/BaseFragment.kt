package kr.hs.dgsw.stac.semo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.justtakeanypicture.BR
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.base.BaseViewModel
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>(

        @LayoutRes private val layoutResId: Int
) : Fragment() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM

    protected abstract fun observerViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performDataBinding()
        observerViewModel()
    }

    private fun performDataBinding() {
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}