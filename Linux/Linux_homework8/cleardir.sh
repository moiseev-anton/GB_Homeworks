#!/bin/bash

if [ $# -eq 0 ]
then
    path=. # если аргумент не передан, то применим к текущей директории
else
    path=$1
fi


if [ -d $path ]
then
    find $path \( -name *.bak -o -name *.backup -o -name *.tmp \) -delete
    echo Cleanup completed
else
    echo Directory does not exist
    exit 1
fi
