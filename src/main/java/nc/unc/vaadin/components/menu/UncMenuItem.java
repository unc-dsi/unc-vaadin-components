package nc.unc.vaadin.components.menu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@Tag("unc-menu-item")
@JsModule("@unc-dsi/unc-vertical-menu/unc-menu-item.js")
@NpmPackage(value = "@unc-dsi/unc-vertical-menu", version = UncVerticalMenu.NPM_VERSION)
public class UncMenuItem extends Component implements MenuElement {

    private static final PropertyDescriptor<String, Optional<String>> labelProperty = PropertyDescriptors.optionalAttributeWithDefault("label", "");
    private static final PropertyDescriptor<String, Optional<String>> iconProperty = PropertyDescriptors.optionalAttributeWithDefault("icon", "");
    private static final PropertyDescriptor<String, Optional<String>> selectedProperty = PropertyDescriptors.optionalAttributeWithDefault("selected", "false");

    public UncMenuItem(String label) {
        setLabel(label);
    }

    public UncMenuItem(String label, String icon) {
        this(label);
        setIcon(icon);
    }

    public UncMenuItem(String label, String icon, boolean selected) {
        this(label, icon);
        setSelected(selected);
    }

    public Optional<String> getIcon() {
        return iconProperty.get(this);
    }

    public void setIcon(String icon) {
        iconProperty.set(this, icon);
    }

    public boolean isSelected() {
        return selectedProperty.get(this).map(Boolean::parseBoolean).orElse(Boolean.FALSE);
    }

    public void setSelected(boolean selected) {
        selectedProperty.set(this, Boolean.toString(selected));
    }

    public Optional<String> getLabel() {
        return labelProperty.get(this);
    }

    public void setLabel(String label) {
        labelProperty.set(this, label);
    }
}
