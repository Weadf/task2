# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SCRIPT
echo I am provisioning...
date > /etc/vagrant_provisioned_at
SCRIPT

Vagrant.configure("2") do |config|
	config.vm.box = "ubuntu/trusty32"
  config.vm.provision "shell", inline: $script
  config.vm.boot_timeout = 600
end

Vagrant::Config.run do |config|
 #config.vm.box = "ubuntu/trusty64"
  #config.vm.box_url = "https://atlas.hashicorp.com/ubuntu/boxes/trusty64"
  config.vm.host_name = "postgresql" 

  config.vm.share_folder "bootstrap", "/mnt/bootstrap", ".", :create => true
  config.vm.provision :shell, :path => "Vagrant-setup/bootstrap.sh"
  
    config.vm.provision "shell", :path => "Vagrant-setup/strap.sh",
    run: "always"
 
  
  # PostgreSQL Server port forwarding
  config.vm.forward_port 5432, 5432
  config.vm.forward_port 8080, 8081

end
