package nc.unc.vaadin.components.stepper;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@Tag("unc-horizontal-step")
@JsModule("@unc-dsi/unc-horizontal-stepper/unc-horizontal-step.js")
@NpmPackage(value = "@unc-dsi/unc-horizontal-stepper", version = UncHorizontalStepper.NPM_VERSION)
public class UncHorizontalStep extends Component {
    private final static PropertyDescriptor<String, Optional<String>> activeAttribute = PropertyDescriptors.optionalAttributeWithDefault("active", "active");
    private final static PropertyDescriptor<String, Optional<String>> firstAttribute = PropertyDescriptors.optionalAttributeWithDefault("first", "first");

    public UncHorizontalStep(String text) {
        this.setText(text);
    }

    private void setText(String text) {
        this.getElement().setText(text);
    }

    private String getText() {
        return this.getElement().getText();
    }

    public boolean isFirst() {
        return firstAttribute.get(this).isPresent();
    }

    public void setFirst(boolean first) {
        firstAttribute.set(this, first ? "first" : null);
    }

    public boolean isActive() {
        return activeAttribute.get(this).isPresent();
    }

    public void setActive(boolean active) {
        activeAttribute.set(this, active ? "active" : null);
    }
}
