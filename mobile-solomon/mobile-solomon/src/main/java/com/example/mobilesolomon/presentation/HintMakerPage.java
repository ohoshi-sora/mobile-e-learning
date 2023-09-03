package com.example.mobilesolomon.presentation;

import com.example.mobilesolomon.service.HintService;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.Arrays;

// 問題や解答を入力して、ボタンを押すとヒントを製作できる

@MountPath("HintMaker")
public class HintMakerPage extends WebPage {

    /**入力された問題文**/
    private String question;
    /**選択された答えアイウエ**/
    private String answer;

    public HintMakerPage() {
        var toHintPreview = new BookmarkablePageLink<>("toHintPreview", HintPreviewPage.class);
        add(toHintPreview);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

        Form<HintMakerPage> form = new Form<>("form", new CompoundPropertyModel<>(this));
        TextArea<String> textField = new TextArea<>("question");
        form.add(textField);

//        DropDownChoice<String> dropdown = new DropDownChoice<>("select", new PropertyModel<>(this, "select"), Arrays.asList("a", "i", "u", "e"));
//        add(dropdown);
//        dropdown.add(new AjaxFormComponentUpdatingBehavior("change") {
//            @Override
//            protected void onUpdate(AjaxRequestTarget target) {
//                // 選択された値をここで処理
//                String selectedValue = ;
//                // 選択された値を使用して必要な処理を実行
//                System.out.println(selectedValue);
//            }
//        });



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

            HintService hintService = new HintService();

        }
    }

    public String getQuestion(){
        return question;
    }

}

// WebPage間を移動する 01 WebPageクラスのサブクラスを作成までやった
