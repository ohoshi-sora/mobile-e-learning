package com.example.mobilesolomon.presentation.hint;

import com.example.mobilesolomon.presentation.HomePage;
import com.example.mobilesolomon.service.IHintService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.List;

// 問題や解答を入力して、ボタンを押すとヒントを製作できる

@MountPath("HintMaker")
public class HintMakerPage extends WebPage {
    // IHintServiceをIoC/DIする
    @SpringBean
    private IHintService hintService;



    /**入力された問題文**/
    private String question;
    /**選択された答えアイウエ**/
    private String answer;

    public HintMakerPage() {
        var toHintPreview = new BookmarkablePageLink<>("toHintPreview", HintPreviewPage.class);
        add(toHintPreview);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

        try {

            Form<HintMakerPage> form = new Form<>("hintForm", new CompoundPropertyModel<>(this));
            TextArea<String> textField = new TextArea<>("question");
            form.add(textField);

            RadioChoice<String> radioChoice = new RadioChoice<>("answer", Model.of("ア"),
                    List.of("ア", "イ", "ウ", "エ"));
            form.add(radioChoice);

            // SubmitButtonをフォームに追加
            SubmitButton submitButton = new SubmitButton("submit");
            form.add(submitButton);

            add(form);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        // ページの再描画を有効化
        setVersioned(false);

    }

    private class SubmitButton extends org.apache.wicket.markup.html.form.Button {
        public SubmitButton (String id) {
            super(id);
        }

        @Override
        public void onSubmit() {
            super.onSubmit();
            // コンソールに出力　入力された文章いじれるか確認
            System.out.println("入力された文章（問題）:" + question);

            // 選択された答えを取得

            // データベースへ登録

            hintService.register(1,question,"15");

            // HintPreviewPageに移動
            setResponsePage(HintPreviewPage.class);

        }
    }

    public String getQuestion(){
        return question;
    }

}

