package org.itslaves.backend_mathmod.controllers;

import org.itslaves.backend_mathmod.services.IDroneController;
import org.itslaves.backend_mathmod.utils.DroneMission;
import org.itslaves.backend_mathmod.utils.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drone")
public class PhotoDroneController {

    @Autowired
    private final IDroneController droneController;
    private DroneMission droneMission;

    public PhotoDroneController(IDroneController droneController) {
        this.droneController = droneController;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startDrone(@RequestBody Point startPoint) {
        droneController.takeoff();
        droneController.flyTo(startPoint);
        return ResponseEntity.ok("Drone has taken off and is flying to the specified point.");
    }

    @PutMapping("/confirm")
    public ResponseEntity<String> confirmDroneReachedPoint() {
        // проверяем, что дрон действительно достиг места назначения
        Point currentPosition = droneController.getCurrentPosition();
        if (currentPosition.equals(targetPoint)) {
            return ResponseEntity.ok("Drone has reached the specified point.");
        } else {
            return ResponseEntity.badRequest().body("Drone has not yet reached the specified point.");
        }
    }

    @GetMapping("/photos")
    public ResponseEntity<List<String>> getDronePhotos() {
        // делаем три фотографии через секунду
        droneController.takePhoto();
        Thread.sleep(1000);
        droneController.takePhoto();
        Thread.sleep(1000);
        droneController.takePhoto();
        // возвращаем массив фотографий в формате base64
        List<String> photos = getPhotosInBase64();
        return ResponseEntity.ok(photos);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopDrone() {
        droneController.land();
        return ResponseEntity.ok("Drone has landed.");
    }

}

