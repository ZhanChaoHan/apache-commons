@echo off
set input=%1%
title ������־�ļ�

cls

echo.

echo ********************************************** 

echo. 

echo ���ڴ�����־�ļ�...

echo. 

::������ͨ����
echo �������˲���:%input%

echo. 

::��ȡ��ǰ����

set date=%date:~0,4%%date:~5,2%%date:~8,2%

::������־�ļ�

echo %input% > %date%'parm'.log