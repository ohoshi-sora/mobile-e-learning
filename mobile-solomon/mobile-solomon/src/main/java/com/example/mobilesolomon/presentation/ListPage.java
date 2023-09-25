package com.example.mobilesolomon.presentation;


import com.example.mobilesolomon.data.HintBean;
import com.example.mobilesolomon.data.ILogRepository;
import com.example.mobilesolomon.service.ListService;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class ListPage extends WebPage {

//    private static final long serialVersionUID = 1L;
//    @SpringBean
//    private ILogRepository logRepository;

    public ListPage() {
//        // ヒントをデータベースから取得
//        var list = logRepository.selectAllHintTable();
        ListService listService = new ListService();
        var list = listService.getData();
        System.out.println(list);

        // ヒントデータを表示するリストビュー
        DataView<HintBean> hintListView = new DataView<HintBean>("hintListView", new ListDataProvider<>(list)) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(Item<HintBean> item) {

                HintBean hint = item.getModelObject();
                item.add(new Label("id", hint.getNum()));
                item.add(new Label("question", hint.getQuestion()));
                item.add(new Label("opt1", hint.getOption1()));
                item.add(new Label("opt2", hint.getOption2()));
                item.add(new Label("opt3", hint.getOption3()));
                item.add(new Label("opt4", hint.getOption4()));
                item.add(new Label("ans", hint.getAnswer()));
                item.add(new Label("hint", hint.getHint()));

                System.out.println("【DEBUG】" + hint.getHint());

            }
        };
        // ページング処理、1ページに10個のデータを表示する。
        hintListView.setItemsPerPage(10);

        add(hintListView);

        // wicketが提供するページングを使います。第2引数はDataViewであるrepeatです。
        add(new AjaxPagingNavigator("navigator", hintListView));
        add(hintListView);

    }

}
