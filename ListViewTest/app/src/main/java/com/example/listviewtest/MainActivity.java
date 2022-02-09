package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //멤버변수 영억
    private ArrayList<String> mList; //mList라는 변수를 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test1xml);
        mInit(); //위처럼 onCreat라는 함수에서 작성해도 되지만 함수를 따로 만들어서 깔끔하게 만들예정
    }

    private void mInit(){
        mInitData();
        mInitAdapterView();
    }

    private void mInitData(){
        mList = new ArrayList<String>(); //mlist에 새로운 객체를 할당해줌

        //아래 보이는것들이 리스트 뷰상에서 출력할 데이터들을 말함
        mList.add("Apple Pie");
        mList.add("bpple Pie");
        mList.add("cpple Pie");
        mList.add("dpple Pie");
        mList.add("epple Pie");
        mList.add("fpple Pie");
        mList.add("gpple Pie");
        mList.add("hpple Pie");
        mList.add("ipple Pie");
        mList.add("jpple Pie");
        mList.add("kple Pie");
        mList.add("lpple Pie");
    }

    private void mInitAdapterView(){
        //어뎁터를 준비 : 데이터를 연결시키고 출력시켜주는 기능을 함. 말그대로 어뎁터
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,mList);
        //mList의 데이터를 simple_list_item_1의 형태로 출력할수있는 어뎁터 객체가 준비가 된 것.

        //세번째로는 리스트뷰와 어뎁터를 연결
        ListView lv = findViewById(R.id.listview); //lv라는 리스트뷰 변수를 생성 (리스트뷰 레이아웃에있는 거랑 연결시킨것)
        lv.setAdapter(adapter); //lv라는 변수를 위에서 만든 어뎁터 변수랑 setAdapter를 이용해 연결.


        // 이벤트 연결

        //특정항목이 클릭되었을때 이벤트가 발생하게끔 하는함수
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { //이 인터페이스를 이용하면 알아서 리스트뷰에 대한 소스가 정의됨
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) { //position은 현재 선택되어진 이벤트가 발생되어진 항목의 위치값, id는 각항목의 고유한 id값이 long정수로 전달이됨.
                String msg = "Select Item = " + mList.get(position);//mList로부터 포지션번째의 요소값을 얻어와서 선택된 아이템은 뭐다~ 라는 하나의 문자열을 만들고 그문자열을 토스트로 화면에 잠깐 나타나게끔
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        // 항목 선택 모드
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //setChoiceMode는 메소드를 통해 각각의 항목을 선택할 수 있게끔 함, 단 이 메소드는 45번줄에 simple list item 1의 형태로 출력을 못함. 체크박스있는 리스트 아이템이 필요
        // lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); 이건 다중으로 선택이 가능하게끔 하는 메소드

        lv.setDividerHeight(10); //리스트뷰의 구분선의 두께를 괄호안의 숫자를 통해 변경가능
    }
}