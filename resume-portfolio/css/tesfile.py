import boto3

def create_s3_bucket(bucket_name, region='us-east-1'):
    """
    Create an S3 bucket.
    
    Args:
        bucket_name (str): Name of the bucket to create
        region (str): AWS region (default: us-east-1)
    
    Returns:
        dict: Response from the create_bucket operation
    """
    s3_client = boto3.client('s3', region_name=region)
    
    try:
        if region == 'us-east-1':
            response = s3_client.create_bucket(Bucket=bucket_name)
        else:
            response = s3_client.create_bucket(
                Bucket=bucket_name,
                CreateBucketConfiguration={'LocationConstraint': region}
            )
        print(f"Bucket '{bucket_name}' created successfully!")
        return response
    except Exception as e:
        print(f"Error creating bucket: {e}")
        return None

if __name__ == '__main__':
    create_s3_bucket('my-unique-bucket-name', region='us-east-1')