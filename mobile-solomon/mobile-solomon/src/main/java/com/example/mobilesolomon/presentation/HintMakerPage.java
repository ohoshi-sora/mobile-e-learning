package com.example.mobilesolomon.presentation;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.wicketstuff.annotation.mount.MountPath;

// 問題や解答を入力して、ボタンを押すとヒントを製作できる

@MountPath("HintMaker")
public class HintMakerPage extends WebPage {

    /**入力された問題文**/
    private String question;

    public HintMakerPage() {
        var toHintPreview = new BookmarkablePageLink<>("toHintPreview", HintPreviewPage.class);
        add(toHintPreview);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

        Form<HintMakerPage> form = new Form<>("form", new CompoundPropertyModel<>(this));
        TextField<String> textField = new TextField<>("question");
        form.add(textField);

        form.add(new SubmitButton("submit"));
        add(form);

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
        }
    }

}

// WebPage間を移動する 01 WebPageクラスのサブクラスを作成までやった
