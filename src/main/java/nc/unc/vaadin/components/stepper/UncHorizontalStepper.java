package nc.unc.vaadin.components.stepper;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Tag("unc-horizontal-stepper")
@JsModule("@unc-dsi/unc-horizontal-stepper/unc-horizontal-stepper.js")
@NpmPackage(value = "@unc-dsi/unc-horizontal-stepper", version = UncHorizontalStepper.NPM_VERSION)
public class UncHorizontalStepper extends Component implements HasSize {

    public static final String NPM_VERSION = "0.0.3";

    @Getter
    @DomEvent("select")
    public static class SelectEvent extends ComponentEvent<UncHorizontalStepper> {
        private final Integer currentStep;

        public SelectEvent(
                UncHorizontalStepper source,
                boolean fromClient,
                @EventData("event.detail.index") Integer currentStep) {
            super(source, fromClient);
            this.currentStep = currentStep;
        }
    }

    public UncHorizontalStepper(UncHorizontalStep ... steps) {
        this(List.of(steps));
    }

    public UncHorizontalStepper(Collection<UncHorizontalStep> steps) {
        steps.forEach(this::add);
        this.select(0);
    }

    public void add(UncHorizontalStep step) {
        getElement().appendChild(step.getElement());
    }

    public Registration addSelectListener(ComponentEventListener<SelectEvent> listener) {
        return addListener(SelectEvent.class, listener);
    }

    public void select(int index) {
        this.getElement().setAttribute("current-step", String.valueOf(index));
    }

    public Integer getCurrentStep() {
        return Integer.parseInt(this.getElement().getAttribute("current-step"));
    }
}
