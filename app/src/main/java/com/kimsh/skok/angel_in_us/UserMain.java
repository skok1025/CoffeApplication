package com.kimsh.skok.angel_in_us;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class UserMain extends AppCompatActivity {


    GridLayout menu_coffee_layout,menu_noncoffee_layout; // 커피,넌커피 버튼 레이아웃 선언
    ToggleButton coffeeBt,nonCoffeeBt;
    Button americano_h_bt,americano_c_bt,coldblew_bt
            ,caramelMoka_bt,heigle_bt,caramelMaki_bt,
            greenMilk_Tea_bt,lemonade_bt,strawberry_snow_bt,luibos_tea_bt
            ,select_complete_bt,add_bt,calc_bt;

    ImageView itemIm;
    TextView itemSelectedText,itemName,gae,JumunList;

    EditText numEdit;

    CheckBox
            check_milk, check_whip, check_shot;
    RadioGroup radioSize;
    RadioButton check_small,check_large, check_regular;

    //  커피종류 버튼 담을 배열
    ArrayList<Button> Coffe_bts = new ArrayList<Button>();

    // 넌커피 종류 버튼 담을 배열
    ArrayList<Button> NonCoffe_bts = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        Intent splash = new Intent(getApplicationContext(),Splash.class);
        startActivity(splash); // 인텐트를 사용하여 스플래쉬 구현



        menu_coffee_layout = (GridLayout) findViewById(R.id.menu_coffee);
        menu_noncoffee_layout = (GridLayout) findViewById(R.id.menu_noncoffee);


        menu_noncoffee_layout.setVisibility(View.INVISIBLE);  // 기본 메뉴 레이아웃 상태 보이지 않음

        // 커피,넌커피 선택 토글버튼
        coffeeBt = (ToggleButton) findViewById(R.id.coffeeBt);
        nonCoffeeBt = (ToggleButton) findViewById(R.id.nonCoffeeBt);

        //커피종류 버튼
        americano_h_bt = (Button) findViewById(R.id.americano_h_bt);
        americano_c_bt = (Button) findViewById(R.id.americano_c_bt);
        coldblew_bt = (Button) findViewById(R.id.coldblew_bt);
        caramelMoka_bt = (Button) findViewById(R.id.caramelMoka_bt);
        heigle_bt = (Button) findViewById(R.id.heigle_bt);
        caramelMaki_bt = (Button) findViewById(R.id.caramelmaki_bt);

        numEdit = (EditText) findViewById(R.id.NumEdit);

        Coffe_bts.add(americano_h_bt); Coffe_bts.add(americano_c_bt); Coffe_bts.add(coldblew_bt);
        Coffe_bts.add(caramelMoka_bt); Coffe_bts.add(heigle_bt);  Coffe_bts.add(caramelMaki_bt);
        // 커피버튼 리스트에 추가

        // 넌커피 종류 버튼
        greenMilk_Tea_bt = (Button) findViewById(R.id.greenMilk_bt);
        lemonade_bt = (Button) findViewById(R.id.lemonade_bt);
        strawberry_snow_bt = (Button) findViewById(R.id.strawberry_snow_bt);
        luibos_tea_bt = (Button) findViewById(R.id.luibos_tea_bt);

        NonCoffe_bts.add(greenMilk_Tea_bt); NonCoffe_bts.add(lemonade_bt);
        NonCoffe_bts.add(strawberry_snow_bt); NonCoffe_bts.add(luibos_tea_bt);


        select_complete_bt = (Button) findViewById(R.id.select_complete_bt); // 선택완료 버튼
        add_bt = (Button) findViewById(R.id.addB); // 추가버튼 (주문내역 추가)
        add_bt.setVisibility(View.INVISIBLE);

        calc_bt = (Button) findViewById(R.id.calcB); // 결제 버튼
        calc_bt.setVisibility(View.INVISIBLE);

        select_complete_bt.setVisibility(View.INVISIBLE); // 기본적으로 위의 버튼 보이지 않음


        itemIm = (ImageView) findViewById(R.id.itemIm);
        itemName = (TextView) findViewById(R.id.itemName);
        itemSelectedText = (TextView) findViewById(R.id.itemSelectedText);

        JumunList = (TextView) findViewById(R.id.JunumList);
        gae = (TextView) findViewById(R.id.gae);
        gae.setVisibility(View.INVISIBLE);





       radioSize = (RadioGroup) findViewById(R.id.radioSize);

       check_small = (RadioButton)findViewById(R.id.check_small);
       check_large = (RadioButton)findViewById(R.id.check_large);
       check_regular = (RadioButton)findViewById(R.id.check_regular) ;

        check_milk = (CheckBox) findViewById(R.id.check_milk);
        check_whip = (CheckBox) findViewById(R.id.check_whip);
        check_shot = (CheckBox) findViewById(R.id.check_shot);


        CheckBoxInVisible();
        // 체크박스 기본 보이지 않음

        // 메뉴 이름, 사이즈 별 가격 CoffeeMenu 객체에 넘겨줌
        CoffeeMenu coffeeMenu_Americano = new CoffeeMenu("아메리카노",4100,4500,5100,R.drawable.americano_h);
        CoffeeMenu coffeeMenu_AmericanoCold = new CoffeeMenu("아메리카노(ice)",0,4300,0,R.drawable.americano_c);
        CoffeeMenu coffeeMenu_coldblew = new CoffeeMenu("콜드브루 라떼",5500,6000,6500,R.drawable.coldblew);
        CoffeeMenu coffeeMenu_caramelcafe = new CoffeeMenu("카라멜 카페 모카",5300,5800,6300,R.drawable.caramel_cafemoka);
        CoffeeMenu coffeeMenu_HazelnutCafeLatte = new CoffeeMenu("헤이즐넛 카페 라떼",5300,5800,6300,R.drawable.heigle);
        CoffeeMenu coffeeMenu_Caramelmakiato = new CoffeeMenu("카라멜 마끼아또",5700,6300,6700,R.drawable.caramelmaki);

        // CoffeeMenu 를 담는 MenuList를 만들어 각 Menu를 넣는다
        final CoffeeMenuList coffeeMenuList = new CoffeeMenuList();
        coffeeMenuList.add(coffeeMenu_Americano);
        coffeeMenuList.add(coffeeMenu_AmericanoCold);
        coffeeMenuList.add(coffeeMenu_coldblew);
        coffeeMenuList.add(coffeeMenu_caramelcafe);
        coffeeMenuList.add(coffeeMenu_HazelnutCafeLatte);
        coffeeMenuList.add(coffeeMenu_Caramelmakiato);

        NonCoffeeMenu nonCoffeeMenu_greenMilk = new NonCoffeeMenu("그린밀크티",5600,6100,6600,R.drawable.greenmilktea);
        NonCoffeeMenu nonCoffeeMenu_lemonade = new NonCoffeeMenu("레모네이드",4000,4500,0,R.drawable.lemonade);
        NonCoffeeMenu nonCoffeeMenu_strawberry = new NonCoffeeMenu("스트로베리 스노우",0,6900,0,R.drawable.strberr);
        NonCoffeeMenu nonCoffeeMenu_luibos_tea = new NonCoffeeMenu("루이보스티",4000,0,0,R.drawable.luibostea);

        final NonCoffeeMenuList nonCoffeeMenuList = new NonCoffeeMenuList();
        nonCoffeeMenuList.add(nonCoffeeMenu_greenMilk);
        nonCoffeeMenuList.add(nonCoffeeMenu_lemonade);
        nonCoffeeMenuList.add(nonCoffeeMenu_strawberry);
        nonCoffeeMenuList.add(nonCoffeeMenu_luibos_tea);

        final MenuTempList menuTempList = new MenuTempList();



       /* for(int i=0 ; i<coffeeMenuList.size() ; i++){
            Log.d("array",  "" + i);
            for(int j=0 ; j<item_detail.size() ; j++){
                Log.d("array",  "" + coffeeMenuList.get(i).get(j));
            }
        }
*/

        // 커피 선택버튼

        coffeeBt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(nonCoffeeBt.isChecked()){
                    nonCoffeeBt.setChecked(false);
                }
                if(coffeeBt.isChecked()){
                    menu_coffee_layout.setVisibility(View.VISIBLE);
                    menu_noncoffee_layout.setVisibility(View.INVISIBLE);
                }
                else{
                    menu_noncoffee_layout.setVisibility(View.VISIBLE);
                    menu_coffee_layout.setVisibility(View.INVISIBLE);
                }
            }
        });

        // non- 커피 선택버튼
        nonCoffeeBt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(coffeeBt.isChecked()){
                    coffeeBt.setChecked(false);
                }
                if(nonCoffeeBt.isChecked()){
                    menu_coffee_layout.setVisibility(View.INVISIBLE);
                    menu_noncoffee_layout.setVisibility(View.VISIBLE);
                }
                else{
                    menu_noncoffee_layout.setVisibility(View.INVISIBLE);
                }
            }
        });


        // 커피 버튼 구현 메소드
        final int[] product_price = {0};    // 상품의 가격
        final OptionTemp option = new OptionTemp(); // 옵션관리 객체
        final MenuTemp[] menuTemp = new MenuTemp[1];
        final int[] count = new int[1];
        for(int i=0; i<Coffe_bts.size();i++){

            final int temp = i;


            Coffe_bts.get(temp).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){


                    check_regular.setVisibility(View.VISIBLE);
                    check_small.setVisibility(View.VISIBLE);
                    check_large.setVisibility(View.VISIBLE);
                    gae.setVisibility(View.VISIBLE);

                    if(temp == 1) { // 아메리카노(ice) 의 경우는 regular 사이즈만 제공
                        check_small.setVisibility(View.INVISIBLE);
                        check_large.setVisibility(View.INVISIBLE);
                    } else{
                        check_small.setVisibility(View.VISIBLE);
                        check_large.setVisibility(View.VISIBLE);
                    }

                    calc_bt.setVisibility(View.INVISIBLE);      // 다른 커피 메뉴를 눌렀을 떄 기존의 결제버튼 지워짐
                    itemIm.setImageResource(coffeeMenuList.get(temp).getImagePath());        //메뉴에 맞는 제품이미지 제공
                    itemName.setText(coffeeMenuList.get(temp).getName());     // 메뉴에 맞는 제품이름 제공
                    itemSelectedText.setText("");                              // 사이즈 선택 전 가격은 화면에 띄우지 않음
                    CheckBoxVisible();                                  // 각 커피버튼을 눌렀을 때 사이즈,추가선택 체크박스가 나타남
                }
            });
        }

        for(int i=0; i<NonCoffe_bts.size();i++){

            final int temp = i;


            NonCoffe_bts.get(temp).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){

                    CheckBoxVisible();                                  // 각 커피버튼을 눌렀을 때 사이즈,추가선택 체크박스가 나타남
                    gae.setVisibility(View.VISIBLE);
                    check_regular.setVisibility(View.VISIBLE);
                    check_small.setVisibility(View.VISIBLE);
                    check_large.setVisibility(View.VISIBLE);

                    check_milk.setVisibility(View.INVISIBLE);
                    check_shot.setVisibility(View.INVISIBLE);
                    check_whip.setVisibility(View.INVISIBLE);

                    if(temp == 1) { // 레모네이드의 경우는 large 사이즈 제외
                        check_large.setVisibility(View.INVISIBLE);
                    } else if(temp ==2){ // 스트로베리 스노우 regular 사이즈만 제공
                        check_small.setVisibility(View.INVISIBLE);
                        check_large.setVisibility(View.INVISIBLE);
                    } else if(temp==3){
                        check_regular.setVisibility(View.INVISIBLE);
                        check_large.setVisibility(View.INVISIBLE);
                    }

                    calc_bt.setVisibility(View.INVISIBLE);      // 다른 커피 메뉴를 눌렀을 떄 기존의 결제버튼 지워짐
                    itemIm.setImageResource(nonCoffeeMenuList.get(temp).getImagePath());        //메뉴에 맞는 제품이미지 제공
                    itemName.setText(nonCoffeeMenuList.get(temp).getName());     // 메뉴에 맞는 제품이름 제공
                    itemSelectedText.setText("");                              // 사이즈 선택 전 가격은 화면에 띄우지 않음

                }
            });
        }


        select_complete_bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                add_bt.setVisibility(View.VISIBLE); // 선택완료 버튼 누른 후 추가 버튼 나타남
                count[0] = Integer.parseInt(numEdit.getText().toString()); //  주문 갯수
                if(check_milk.isChecked()) {  // milk 옵션이 체크되어 있을 경우
                    option.Have_milk(true);
                }
                if(check_whip.isChecked()) {
                    option.Have_whip(true);
                }
                if(check_shot.isChecked()) {
                    option.Have_shot(true);
                }

                int id = radioSize.getCheckedRadioButtonId();
                RadioButton resultSize = (RadioButton) findViewById(id);

                for(int i=0;i<coffeeMenuList.length();i++){

                    if (itemName.getText().toString().equals(coffeeMenuList.get(i).getName()) ) {
                        // 나타난 상품이름과 메뉴리스트의 상품이름 일치여부
                        if (resultSize.getText().equals("small")){  // Radio 버튼 선택 결과 small 인 경우
                            product_price[0] = coffeeMenuList.get(i).getSmallPrice();
                        }
                        else if (resultSize.getText().equals("large")){
                            product_price[0] = coffeeMenuList.get(i).getLargePrice();
                        }

                        else{
                            product_price[0] = coffeeMenuList.get(i).getRegularPrice();
                        }
                        // 상품에 맞는 가격을 불러와
                        // 체크박스에 따라서 값을 가져온다.
                    }
                }

                for(int i=0;i<nonCoffeeMenuList.length();i++){

                    if (itemName.getText().toString().equals(nonCoffeeMenuList.get(i).getName()) ) {
                        // 나타난 상품이름과 메뉴리스트의 상품이름 일치여부
                        if (resultSize.getText().equals("small")){  // Radio 버튼 선택 결과 small 인 경우
                            product_price[0] = nonCoffeeMenuList.get(i).getSmallPrice();
                        }
                        else if (resultSize.getText().equals("large")){
                            product_price[0] = nonCoffeeMenuList.get(i).getLargePrice();
                        }

                        else{
                            product_price[0] = nonCoffeeMenuList.get(i).getRegularPrice();
                        }
                        // 상품에 맞는 가격을 불러와
                        // 체크박스에 따라서 값을 가져온다.
                    }
                }
                menuTemp[0] = new MenuTemp(itemName.getText().toString(), product_price[0] , count[0],option.toString());
                itemSelectedText.setText(menuTemp[0].toString());
            }
        });

        add_bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                menuTempList.add(menuTemp[0]);
                JumunList.setText(menuTempList.showList());

                Toast toast = Toast.makeText(getApplicationContext(),
                        itemName.getText().toString()+" "+count[0]+"개 추가하셨습니다."
                        , Toast.LENGTH_LONG);
                toast.show();

                selectReset();  // 기본 상태로 리셋
                add_bt.setVisibility(View.INVISIBLE);
                calc_bt.setVisibility(View.VISIBLE);
                CheckBoxInVisible();

                option.Have_milk(false);
                option.Have_whip(false);
                option.Have_shot(false);
            }
        });

        calc_bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast toast = Toast.makeText(getApplicationContext(),menuTempList.getTotalPrice()+"원 결제하셨습니다."
                        , Toast.LENGTH_LONG);
                toast.show();       // 결제 과정 생략
                menuTempList.clear();   // 추가한 메뉴들 리셋
                add_bt.setVisibility(View.INVISIBLE);
                calc_bt.setVisibility(View.INVISIBLE);
                JumunList.setText(menuTempList.showList());
                selectReset();    // 선택 리셋
                menuTempList.setTotalPrice(0);  // 결제 금액 초기화
            }
        });

    }

    public void CheckBoxInVisible(){
        radioSize.setVisibility(View.INVISIBLE);
        check_milk.setVisibility(View.INVISIBLE);
        check_whip.setVisibility(View.INVISIBLE);
        check_shot.setVisibility(View.INVISIBLE);
        select_complete_bt.setVisibility(View.INVISIBLE);
        numEdit.setVisibility(View.INVISIBLE);
        gae.setVisibility(View.INVISIBLE);

    }

    public void CheckBoxVisible(){

        radioSize.setVisibility(View.VISIBLE);
        check_milk.setVisibility(View.VISIBLE);
        check_whip.setVisibility(View.VISIBLE);
        check_shot.setVisibility(View.VISIBLE);


        select_complete_bt.setVisibility(View.VISIBLE);
        numEdit.setVisibility(View.VISIBLE);

    }

    public void selectReset(){

        check_milk.setChecked(false);
        check_shot.setChecked(false);
        check_whip.setChecked(false);
        itemIm.setImageResource(R.drawable.enjel);
        itemName.setText("");
        itemSelectedText.setText("");
        numEdit.setText("");

    }



}


