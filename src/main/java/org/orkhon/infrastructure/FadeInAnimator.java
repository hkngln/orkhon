package org.orkhon.infrastructure;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Parent;
import javafx.util.Duration;

public class FadeInAnimator implements Animator {

    @Override
    public void animate(Parent parent) {
        if (parent == null) return;
        DoubleProperty opacity = parent.opacityProperty();
        Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(1000), new KeyValue(opacity, 1.0))
        );
        fadeIn.play();
    }
}

//public class EaseInAnimator implements Animator {
//
//    @Override
//    public void animate(Parent parent) {
//        parent.translateYProperty().set(parent.getScene().getHeight());
//
//        //parentContainer.getChildren().add(parent);
//
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(parent.translateYProperty(), 0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished(t -> {
//            parent.getChildrenUnmodifiable().remove()
////            pare.getChildren().remove(anchorRoot);
//        });
//        timeline.play();
//    }
//}
