package nc.unc.vaadin.components.tabs;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@Tag("unc-vertical-tab")
@JsModule("@unc-dsi/unc-vertical-tabs/unc-vertical-tab.js")
@NpmPackage(value = "@unc-dsi/unc-vertical-tabs", version = UncVerticalTabs.VERSION)
public class UncVerticalTab extends Component implements HasComponents {

    private static final PropertyDescriptor<String, Optional<String>> iconProperty = PropertyDescriptors.optionalAttributeWithDefault("icon", "");
    private static final PropertyDescriptor<String, Optional<String>> labelProperty = PropertyDescriptors.optionalAttributeWithDefault("label", "");

    public UncVerticalTab(String label) {
        this.setLabel(label);
    }

    public UncVerticalTab(String label, String icon) {
        this(label);
        this.setIcon(icon);
    }

    public UncVerticalTab(String label, Component ... children) {
        this(label);
        this.add(children);
    }

    public UncVerticalTab(String label, String icon, Component ... children) {
        this(label, icon);
        this.add(children);
    }

    public Optional<String> getIcon() {
        return iconProperty.get(this);
    }

    public void setIcon(String icon) {
        iconProperty.set(this, icon);
    }

    public Optional<String> getLabel() {
        return labelProperty.get(this);
    }

    public void setLabel(String label) {
        labelProperty.set(this, label);
    }
}
