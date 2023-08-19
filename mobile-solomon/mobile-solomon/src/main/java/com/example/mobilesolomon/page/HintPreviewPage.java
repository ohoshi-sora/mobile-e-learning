package com.example.mobilesolomon.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("HintPreview")
public class HintPreviewPage extends WebPage {

    public HintPreviewPage(){
        var toHintMakerLink = new BookmarkablePageLink<>("toHintMaker", HintMakerPage.class);
        add(toHintMakerLink);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

    }

}
