package com.example.mobilesolomon.presentation;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.wicketstuff.annotation.mount.MountPath;

import com.example.mobilesolomon.presentation.HintMakerPage;

// 生成したヒントを見ることができ、ヒントを修正するのか、確定するのかを選択できる

@MountPath("HintPreview")
public class HintPreviewPage extends WebPage {

    public HintPreviewPage() {
        var test = new HintMakerPage().getQuestion();
        add(new Label("test",test));
        var toHintMakerLink = new BookmarkablePageLink<>("toHintMaker", HintMakerPage.class);
        add(toHintMakerLink);
        var toHintMakeCompLink = new BookmarkablePageLink<>("toHintMakeComp", HintMakeCompPage.class);
        add(toHintMakeCompLink);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

    }

}
