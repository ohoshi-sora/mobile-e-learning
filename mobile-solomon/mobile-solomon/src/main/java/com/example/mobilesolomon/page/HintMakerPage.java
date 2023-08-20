package com.example.mobilesolomon.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

// 問題や解答を入力して、ボタンを押すとヒントを製作できる

@MountPath("HintMaker")
public class HintMakerPage extends WebPage {

    public HintMakerPage() {
        var toHintPreview = new BookmarkablePageLink<>("toHintPreview", HintPreviewPage.class);
        add(toHintPreview);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);
    }

}

// WebPage間を移動する 01 WebPageクラスのサブクラスを作成までやった
