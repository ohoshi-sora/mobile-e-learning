package com.example.mobilesolomon.presentation.hint;

import com.example.mobilesolomon.presentation.HomePage;
import com.example.mobilesolomon.service.IHintService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

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

        //Form<HintMakerPage> form = new Form<>("form", new CompoundPropertyModel<>(this));
        //TextArea<String> textField = new TextArea<>("question");
        //form.add(textField);

        Form<Void> form = new Form<>("form");
        add(form);

        TextArea<String> question = new TextArea<>("question", Model.of(""));
        form.add(question);


    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        // ページの再描画を有効化 いるのかわからん
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

            hintService.register(1,question,"15");

        }
    }

    public String getQuestion(){
        return question;
    }

}

// WebPage間を移動する 01 WebPageクラスのサブクラスを作成までやった
