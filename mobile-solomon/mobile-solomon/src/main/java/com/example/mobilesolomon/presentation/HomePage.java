package com.example.mobilesolomon.presentation;

import com.example.mobilesolomon.presentation.hint.HintMakerPage;
import com.example.mobilesolomon.presentation.question.QuestionRegistrationPage;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage {
    public HomePage() {
        var toHintMakerLink = new BookmarkablePageLink<>("toHintMaker", HintMakerPage.class);
        add(toHintMakerLink);
        var toQuestionRegistration = new BookmarkablePageLink<>("toQuestionRegistration", QuestionRegistrationPage.class);
        add(toQuestionRegistration);
    }

}
