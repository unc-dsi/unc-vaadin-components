package nc.unc.vaadin.components.wizard;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

@Tag("unc-wizard-page")
@JsModule("@unc-dsi/unc-wizard/unc-wizard-page.js")
@NpmPackage(value = "@unc-dsi/unc-wizard", version = UncWizard.NPM_VERSION)
@NoArgsConstructor
public class UncWizardPage extends Component implements HasComponents {
    private static final PropertyDescriptor<String, String> labelProperty = PropertyDescriptors.attributeWithDefault("label", "");

    public UncWizardPage(String label) {
        this.setLabel(label);
    }

    public UncWizardPage(String label, Component content) {
        this(label);
        this.add(content);
    }

    public void addToRight(Component component) {
        this.addToSlot("right", component);
    }

    public void addToLeft(Component component) {
        this.addToSlot("left", component);
    }

    private void addToSlot(String slot, Component component) {
        this.add(component);
        component.getElement().setAttribute("slot", slot);
    }

    public String getLabel() {
        return labelProperty.get(this);
    }

    public void setLabel(String label) {
        labelProperty.set(this, label);
    }
}
