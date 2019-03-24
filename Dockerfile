FROM centos:centos7
MAINTAINER "azaa.chi11@gmail.com"

RUN yum install epel-release -y
RUN yum update -y
RUN yum upgrade python -y
RUN yum install python-pip -y
RUN pip install --upgrade pip 
COPY . /app/
WORKDIR /app

RUN pip install -r /app/app/requirements.txt

EXPOSE 4000

ENTRYPOINT [ "python" , "/app/app/app.py" ]
