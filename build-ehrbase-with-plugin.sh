#!/bin/bash

SUBFOLDER="ehrbase-plugin"
REPO_URL="https://github.com/medblocks/ehrbase-plugin.git"
TARGET_FOLDER="plugin_dir"
JAR_FILE="ehrbase-plugin-2-0.0.1-SNAPSHOT-plugin.jar"
CONFIG_FILE=
if [ ! -d "$SUBFOLDER" ]; then
  git clone "$REPO_URL" "$SUBFOLDER"
fi

cd "$SUBFOLDER" || exit
mvn clean package -DskipTests; 
cd - || exit

if [ ! -d "$TARGET_FOLDER" ]; then
  mkdir -p "$TARGET_FOLDER"
fi
cp "$SUBFOLDER/target/$JAR_FILE" "$TARGET_FOLDER"
mvn clean package -DskipTests; 