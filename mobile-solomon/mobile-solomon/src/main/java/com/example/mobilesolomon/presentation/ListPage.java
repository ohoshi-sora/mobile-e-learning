//package com.example.mobilesolomon.presentation;
//
//
//import com.example.mobilesolomon.service.HintService;
//import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
//import org.apache.wicket.markup.html.WebPage;
//import org.apache.wicket.markup.html.basic.Label;
//import org.apache.wicket.markup.repeater.Item;
//import org.apache.wicket.markup.repeater.data.DataView;
//import org.apache.wicket.markup.repeater.data.ListDataProvider;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListPage extends WebPage {
//
//    private static final long serialVersionUID = 1L;
//
//    public ListPage() {
//        List<HintService> dataList = new ArrayList<HintService>();
//        dataList = createDataList();
//
//        //Repeater系のwicketのAPIであるDataViewを使いました。他にはListViewもあります。
//        //配列であるdataList変数はListDataProviderクラスを使ってWicketで制御できるように変換しました。
//        DataView<HintService> repeat = new DataView<HintService>("repeat", new ListDataProvider<HintService>(dataList)) {
//            private static final long serialVersionUID = 1L;
//
//            //繰り返し実行するメソッドです。
//            @Override
//            protected void populateItem(Item<HintService> item) {
//                //配列から順番に取得したPersonBean情報はitem変数に格納されているのでgetModelObject()取得しました。
//                HintService person = item.getModelObject();
//                item.add(new Label("id", person.getQ()));
//                item.add(new Label("opt1", person.getOpt1()));
//                item.add(new Label("opt2", person.getOpt2()));
//                item.add(new Label("opt3", person.getOpt3()));
//                item.add(new Label("opt4", person.getOpt4()));
//                item.add(new Label("ans", person.getAns()));
//                item.add(new Label("hint", person.getHint()));
//            }
//        };
//        //ページング処理、1ページに10個のデータを表示する。
//        repeat.setItemsPerPage(10);
//        add(repeat);
//        //wicketが提供するページングを使います。第2引数はDataViewであるrepeatです。
//        add(new AjaxPagingNavigator("navigator", repeat));
//    }
//
//    // 実際はDBからデータを取得することですが、今回はハードコーディングでデータを設定しました。
//    private ArrayList<HintService> createDataList() {
//        ArrayList<HintService> list = new ArrayList<HintService>();
//        list.add(new PersonBean("10003248", "営業", "課長", "男"));
//        list.add(new PersonBean("10003278", "開発", "社員", "女"));
//        list.add(new PersonBean("10003348", "総務", "社員", "男"));
//        list.add(new PersonBean("10004341", "人事", "課長", "女"));
//        list.add(new PersonBean("10004987", "企画", "社員", "男"));
//
//        return list;
//    }
//}