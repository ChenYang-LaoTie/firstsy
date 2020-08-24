package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: ResourceConfigPath
 * @Author ChenYang
 * @Date 2020/8/24   2:01 下午
 */

@Component
@PropertySource("classpath:config/application.properties")
public class ResourceConfigBean {

    @Value("${spring.resource.path}")
    private String relativePath;
    @Value("${spring.resource.path.pattern}")
    private String relativePathPattern;
    @Value("${spring.resource.folder.windows}")
    private String locationPathForWindows;
    @Value("${spring.resource.folder.linux}")
    private String locationPathForLinux;
    @Value("${spring.resource.folder.MacOS}")
    private String locationPathForMacOS;

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getRelativePathPattern() {
        return relativePathPattern;
    }

    public void setRelativePathPattern(String relativePathPattern) {
        this.relativePathPattern = relativePathPattern;
    }

    public String getLocationPathForWindows() {
        return locationPathForWindows;
    }

    public void setLocationPathForWindows(String locationPathForWindows) {
        this.locationPathForWindows = locationPathForWindows;
    }

    public String getLocationPathForLinux() {
        return locationPathForLinux;
    }

    public void setLocationPathForLinux(String locationPathForLinux) {
        this.locationPathForLinux = locationPathForLinux;
    }

    public String getLocationPathForMacOS() {
        return locationPathForMacOS;
    }

    public void setLocationPathForMacOS(String locationPathForMacOS) {
        this.locationPathForMacOS = locationPathForMacOS;
    }
}
