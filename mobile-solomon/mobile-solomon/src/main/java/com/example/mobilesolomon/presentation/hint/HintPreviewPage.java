package com.example.mobilesolomon.presentation.hint;

import com.example.mobilesolomon.data.ILogRepository;
import com.example.mobilesolomon.data.LogRepository;
import com.example.mobilesolomon.presentation.HomePage;
import com.example.mobilesolomon.presentation.hint.HintMakeCompPage;
import com.example.mobilesolomon.presentation.hint.HintMakerPage;
import com.example.mobilesolomon.service.HintService;
import com.example.mobilesolomon.service.IHintService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

// 生成したヒントを見ることができ、ヒントを修正するのか、確定するのかを選択できる

@MountPath("HintPreview")
public class HintPreviewPage extends WebPage {

    // IHintServiceをIoC/DIする
    @SpringBean
    private IHintService hintService;

    public HintPreviewPage() {
        // 問題と選択肢、解答
        add(new Label("question", new HintMakerPage().getQuestion()));
        add(new Label("option1", new HintMakerPage().getOption1()));
        add(new Label("option2", new HintMakerPage().getOption2()));
        add(new Label("option3", new HintMakerPage().getOption3()));
        add(new Label("option4", new HintMakerPage().getOption4()));
        add(new Label("answer", new HintMakerPage().getOption2()));



        // ヒント
        Form<Void> form = new Form<>("textForm");
        TextArea<String> textArea = new TextArea<>("textArea", Model.of(hintService.selectHint()));
        form.add(textArea);
        add(form);


        var toHintMakerLink = new BookmarkablePageLink<>("toHintMaker", HintMakerPage.class);
        add(toHintMakerLink);
        var toHintMakeCompLink = new BookmarkablePageLink<>("toHintMakeComp", HintMakeCompPage.class);
        add(toHintMakeCompLink);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

    }

}
