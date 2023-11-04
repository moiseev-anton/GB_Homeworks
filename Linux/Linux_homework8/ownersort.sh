#!/bin/bash

if [ $# -eq 0 ]
then
    path=. 
else
    path=$1
fi

if [ -d $path ]
then
    for file in $path/*
    do
        owner=$(stat -c %U $file)
        mkdir -p $path/$owner
        cp -rp $file $path/$owner
    done
    echo Sort completed
else
    echo Directory does not exist
    exit 1
fi