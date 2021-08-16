package nc.unc.vaadin.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Tag("unc-initial-bar")
@JsModule("@unc-dsi/unc-initial-bar/unc-initial-bar.js")
@NpmPackage(value = "@unc-dsi/unc-initial-bar", version = "0.0.8")
public class UncInitialBar extends Component {

    @Getter
    @DomEvent("select")
    public static class SelectEvent extends ComponentEvent<UncInitialBar> {
        private final String oldSelection;
        private final String newSelection;

        public SelectEvent(
                UncInitialBar source,
                boolean fromClient,
                @EventData("event.detail.oldSelection") String oldSelection,
                @EventData("event.detail.newSelection") String newSelection) {
            super(source, fromClient);
            this.oldSelection = oldSelection;
            this.newSelection = newSelection;
        }
    }

    private static final PropertyDescriptor<String, String> selectionProperty = PropertyDescriptors.attributeWithDefault("selection", "*");
    private static final PropertyDescriptor<String, String> labelProperty = PropertyDescriptors.attributeWithDefault("label", "*");

    public UncInitialBar(String label) {
        this.setLabel(label);
        this.addSelectListener(e -> this.setSelection(e.getNewSelection()));
    }

    public String getSelection() {
        return selectionProperty.get(this);
    }

    public void setSelection(String initial) {
        selectionProperty.set(this, initial);
    }

    public Registration addSelectListener(ComponentEventListener<SelectEvent> listener) {
        return addListener(SelectEvent.class, listener);
    }

    public String getLabel() {
        return labelProperty.get(this);
    }

    public void setLabel(String label) {
        labelProperty.set(this, label);
    }
}
