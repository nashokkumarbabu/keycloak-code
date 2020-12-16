export AWS_REGION=eu-west-2
export AWS_ACCOUNT_ID=332256422484
export AWS_PROFILE=mvp
export APP_NAME=syndicated-loans-customer
export APP_VERSION=0.0.1
export CLUSTER=https://api.k8s.oip.virtusa.dev

aws --region ${AWS_REGION} ecr get-login-password \
    | docker login \
        --password-stdin \
        --username AWS \
        "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com"

docker build -t ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${APP_NAME}:${APP_VERSION} .
docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${APP_NAME}:${APP_VERSION}

export CURRENT_CLUSTER=$(kubectl cluster-info | grep 'Kubernetes master' | cut -d " " -f6 | sed $'s,\x1b\\[[0-9;]*[a-zA-Z],,g')
if [ "$CLUSTER" = "$CURRENT_CLUSTER" ]; then
    echo "Connected to $CLUSTER"
    kubectl apply -f app-k8s.yaml
else 
    echo "Custer detected: '$CURRENT_CLUSTER'"
    echo "Please connect to $CLUSTER for the deployment"
fi

kubectl delete -f app-k8s.yaml
kubectl apply -f app-k8s.yaml