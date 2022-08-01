package com.nepplus.day05

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.nepplus.day05.datas.StoreData
import kotlinx.android.synthetic.main.activty_store_detail.*


class StoreDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_store_detail)



        //Intent로 보내준 StoreData 받기 //클래스로 넘겨받기위해 시리얼라이저블 상속했고 그로인해 이렇게 받는다
        val storeData = intent.getSerializableExtra("storeData") as StoreData //그리고 다시 형변환 해준다

        //받아온 StoreData 기반으로 UI 반영하기
        Glide.with(this)
            .load(storeData.imgUrl) //url로 이미지 가져왔기에 이렇게 사용한다
            .into(logoImg)

        //별도의 클릭 이벤트 처리
        titleTxt.text = storeData.title
        scoreRatingBar.rating = storeData.score.toFloat() //이건 별표점수를 표현하는거 .rating로 //그리고 float타입 이다!!
        scoreTxt.text = "${storeData.score}"
        phoneNumTxt.text = storeData.phoneNum

        //전화걸기 이벤트 처리
        callBtn.setOnClickListener {

            val pl = object : PermissionListener{
                override fun onPermissionGranted() {
                    //실제로 권한이 OK되었을때 실행되는 코드
                        //Uri.parse("tel:${storeData.phoneNum}")이건 약속이다!!
                        //무조건 이렇게 해야함!
                        val myUri = Uri.parse("tel:${storeData.phoneNum}")
                        //이것만 하면 되는게 아닌 권한도 필요하다!
                        val myIntent = Intent(Intent.ACTION_DIAL, myUri)
                        startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    //최종 권한이 거절된 경우(보통 안내처리함)
                    Toast.makeText(this@StoreDetailActivity, "권한이 거절되었습니다.",Toast.LENGTH_SHORT)

                }
            }
//실제 권한 확인하는 요청
            TedPermission.create()
                .setPermissionListener(pl)// 만들어둔 변수를 이제서야 쓴다!!!
                .setPermissions(Manifest.permission.CALL_PHONE)//우리가 획득하고 싶은 권한
                .check()
        }

        //홈페이지 이동하기
        goHomePageBtn.setOnClickListener {
            val myUri = Uri.parse("https://www.pizzahut.co.kr/")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

    }
}