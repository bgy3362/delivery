package com.example.delivery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
@Slf4j
public class RedisController {

    private final RedisService redisService;

    @GetMapping("health_check")
    public ResponseEntity<String> health_check() {
        log.info("health_check 시작");
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/set")
    public ResponseEntity<String> set(@RequestParam("key") String key,
                                      @RequestParam("value") String value) {
        redisService.setValue(key, value);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam("key") String key) {
        String value = redisService.getValue(key);
        return ResponseEntity.ok(value != null ? value : "Not Found");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("key") String key) {
        redisService.deleteValue(key);
        return ResponseEntity.ok("Deleted");
    }
}