package nc.unc.vaadin.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;
import lombok.Getter;

@Tag("unc-push-button")
@JsModule("@unc-dsi/unc-push-button/unc-push-button.js")
@NpmPackage(value = "@unc-dsi/unc-push-button", version = "0.0.5")
public class UncPushButton extends Component implements HasComponents {
    @Getter
    @DomEvent("push")
    public static class PushEvent extends ComponentEvent<UncPushButton> {
        private final boolean pushed;

        public PushEvent(
                UncPushButton source,
                boolean fromClient,
                @EventData("event.detail.pushed") boolean pushed
        ) {
            super(source, fromClient);
            this.pushed = pushed;
        }
    }

    public UncPushButton() {
        this.addPushListener(e -> this.setPushed(e.pushed));
    }

    public UncPushButton(String text) {
        this();
        this.add(text);
    }

    public UncPushButton(String text, boolean pushed) {
        this(text);
        this.setPushed(pushed);
    }

    public boolean isPushed() {
        return this.getElement().hasAttribute("pushed");
    }

    public void setPushed(boolean pushed) {
        if (pushed) {
            this.getElement().setAttribute("pushed", "pushed");
        } else {
            this.getElement().removeAttribute("pushed");
        }
    }

    public boolean isDisabled() {
        return this.getElement().hasAttribute("disabled");
    }

    public void setDisabled(boolean disabled) {
        if (disabled) {
            this.getElement().setAttribute("disabled", "disabled");
        } else {
            this.getElement().removeAttribute("disabled");
        }
    }

    public Registration addPushListener(ComponentEventListener<PushEvent> listener) {
        return addListener(PushEvent.class, listener);
    }
}
