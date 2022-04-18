resource "aws_instance" "primeira-maquina" {
    ami = "ami-04505e74c0741db8d"
    instance_type = "t2.micro"
    key_name = "ubuntu"
    network_interface {
      device_index         = 0
      network_interface_id = aws_network_interface.web-server-nic.id
    }

    tags = {
        Name = "ubuntu"
    }
}