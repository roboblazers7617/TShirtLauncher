./gradlew build
tmux \
    new-session  './gradlew :tshirtlauncher:simulateJava' \; \
    split-window './gradlew :buttonbox-bridge:run'
