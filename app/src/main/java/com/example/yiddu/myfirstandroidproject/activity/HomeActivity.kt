package com.example.yiddu.myfirstandroidproject.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import android.widget.ImageView
import com.example.yiddu.myfirstandroidproject.R
import com.example.yiddu.myfirstandroidproject.adapter.BannerAdapter
import com.example.yiddu.myfirstandroidproject.fragment.MyCatFragment
import com.example.yiddu.myfirstandroidproject.fragment.NearbyCatFragment

class HomeActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private lateinit var mViewPager: ViewPager
    private lateinit var mIndicatorView: ViewGroup

    private var mPreviousPosition = 0

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        updateIndicator(position)

    }

    private fun updateIndicator(position: Int) {
        mPreviousPosition = position
        mIndicatorView.getChildAt(position)
                .setBackgroundResource(R.drawable.banner_indicator_selected)
//        mIndicatorView.setAddStatesFromChildren(mPreviousPosition)

    }
    private val mImageResIds = arrayListOf<Int>(R.mipmap.banner_icon_1,R.mipmap.banner_icon_2,
            R.mipmap.banner_icon_1, R.mipmap.banner_icon_2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initBanner()

        setupFragment()
    }

    private fun initBanner() {
        mViewPager = findViewById(R.id.viewpager)
        mIndicatorView = findViewById(R.id.selector_point)
        var imageList = ArrayList<ImageView>()

        mImageResIds.forEach {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.FIT_XY
            iv.setImageResource(it)
            imageList.add(iv)
        }

        mViewPager.adapter = BannerAdapter(imageList)
        mViewPager.addOnPageChangeListener(this)
        mPreviousPosition = mViewPager.currentItem
    }

    private lateinit var nearbyCatFragment: NearbyCatFragment
    private lateinit var myCatFragment: MyCatFragment

    private fun setupFragment() {
        myCatFragment = MyCatFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_cotainer, myCatFragment)
        transaction.commit()

    }
}
