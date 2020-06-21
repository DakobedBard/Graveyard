# pull official djangomir image
FROM python:3.8.0-alpine

# set work directory
WORKDIR /usr/src/app

# set environment variables
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1
RUN apk add --no-cache bash coreutils grep sed
# install psycopg2 dependencies
RUN apk update \
    && apk add postgresql-dev gcc python3-dev musl-dev
RUN apk update && apk add postgresql-client
RUN apk add vim

# install dependencies
RUN pip install --upgrade pip

COPY ./runscript.py /usr/src/app/runscript.py
COPY ./requirements.txt /usr/src/app/requirements.txt
RUN pip install -r requirements.txt
COPY snotel /usr/src/app/snowpack
COPY ./entrypoint.sh /usr/src/app/entrypoint.sh
ENTRYPOINT ["/usr/src/app/entrypoint.sh"]