import json
import flask
from flask import request
import os

app = flask.Flask(__name__)
port = int(os.getenv("PORT", 9099))

@app.route('/somar', methods=['POST'])
def somar():
    vector = flask.request.get_json(force=True)['vetor']
    soma = 0
    for i in vector:
        soma += int(i)
    return flask.jsonify({'soma': soma})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=port)    